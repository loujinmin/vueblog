module.exports = {
  devServer: {
    // 跨域
    proxy: {
      '/api': {
        // 目标路径
        target: 'http://127.0.0.1/',
        // 允许跨域
        changeOrigin: true,
        // 重写路径
        pathRewrite: {
          '^/api': ''
        }
      }
    }
  }
}