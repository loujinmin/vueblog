<template>
  <div>
    <Header></Header>

    <div class="block">
      <div class="filter-container">
        <el-input placeholder="博客标题" v-model="pagination.title" style="width: 200px;" class="filter-item"></el-input>
        <el-input placeholder="博客描述" v-model="pagination.description" style="width: 200px;" class="filter-item"></el-input>
        <el-input placeholder="博客内容" v-model="pagination.content" style="width: 200px;" class="filter-item"></el-input>
        <el-button @click="page()" type="primary">查询</el-button>
      </div>
      <el-timeline>
        <el-timeline-item placement="top" v-for="blog in blogs" :key="blog.id">
          <el-card>
            <h4 @click="goDetail(blog.id)">
              {{blog.title}}
            </h4>
            <p>{{blog.description}}</p>
          </el-card>
        </el-timeline-item>
      </el-timeline>
      <el-pagination class="mpage" background layout="prev, pager, next" :total="total" :current-page="currentPage" :page-size="pageSize" @current-change=page>
      </el-pagination>
    </div>
  </div>
</template>

<script>
import Header from '@/components/Header'
export default {
  name: 'Blogs',
  components: { Header },
  data() {
    return {
      blogs: {},
      currentPage: 1,
      total: 0,
      pageSize: 5,
      pagination: {
        title: '',
        description:'',
        content: ''
      },
      params: ''
    }
  },
  created() {
    this.page(1)
  },
  methods: {
    page(currentPage) {
      this.params = '?title=' + this.pagination.title
      this.params += '&description=' + this.pagination.description
      this.params += '&content=' + this.pagination.content
      // console.log(this.params);
      const _this = this
      _this.$axios.get('/api/blogs/' + this.currentPage + '/' + this.pageSize + this.params).then(res => {
        // console.log(res.data)
        _this.blogs = res.data.data.records
        _this.total = res.data.data.total
        _this.pageSize = res.data.data.size
      })
    },
    goDetail(id) {
      this.$router.push({
        name: 'BlogDetail',
        params: { blogId: id }
      })
    }
  }
}
</script>

<style scoped>
.mpage {
  margin: 0 auto;
  text-align: center;
}
.filter-container {
  text-align: center;
}
</style>