<template>
  <div class="m-content">
    <h3>欢迎来到VueBlog</h3>
    <div class="block">
      <el-avatar :size="50" :src="user.avatar"></el-avatar>
      <div>{{ user.username }}</div>
    </div>

    <div class="maction">
      <span>
        <el-link type="primary" href="/blogs">主页</el-link>
      </span>
      <el-divider direction="vertical"></el-divider>
      <span>
        <el-link type="success" href="/blog/add">发表博客</el-link>
      </span>
    </div>

  </div>
</template>

<script>
export default {
  name: 'Header',
  data() {
    return {
      user: {
        username: '嗨害嗨',
        avatar: 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png'
      },
      hasLogin: false
    }
  }
}
</script>

<style scoped>
.m-content {
  max-width: 960px;
  margin: 0 auto;
  text-align: center;
}
.maction {
  margin: 10px 0;
}
</style>