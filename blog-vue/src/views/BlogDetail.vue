<template>
  <div>
    <Header></Header>
    <div class="m-blog">
      <h2>{{blog.title}}</h2>
      <el-link icon="el-icon-edit" @click="goEdit" style="padding: 0 20px 0 0">
        编辑
      </el-link>
      <el-link icon="el-icon-delete" @click="goDelete">
        删除
      </el-link>
      <el-divider></el-divider>
      <div class="markdown-body" v-html="blog.content"></div>
    </div>
  </div>
</template>

<script>
import Header from '../components/Header.vue'
import 'github-markdown-css'

export default {
  name: 'BlogDetail',
  components: { Header },
  data() {
    return {
      blog: {
        id: '',
        title: '',
        content: ''
      }
    }
  },
  created() {
    const blogId = this.$route.params.blogId
    // console.log(blogId)
    const _this = this
    if (blogId) {
      _this.$axios.get('/api/blogs/' + blogId).then(res => {
        // console.log(res.data)
        const blog = res.data.data
        _this.blog.id = blog.id
        _this.blog.title = blog.title

        const MardownIt = require('markdown-it')
        const md = new MardownIt()
        const result = md.render(blog.content)

        _this.blog.content = result
      })
    }
  },
  methods: {
    goEdit() {
      this.$router.push({
        name: 'BlogEdit',
        params: { blogId: this.blog.id }
      })
    },
    goDelete() {
      const _this = this
      _this.$axios.delete('/api/blogs/' + this.blog.id).then(res => {
        // console.log(res.data)
        this.$message({
          type: 'success',
          message: '删除成功'
        })
      })
      _this.$router.push('/blogs')
    }
  }
}
</script>

<style>
.m-blog {
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  width: 100%;
  min-height: 700px;
  padding: 20px 15px;
}
</style>