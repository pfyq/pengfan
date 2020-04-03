
import Vue from 'vue'
import router from '@/router'
import NProgress from 'nprogress' // progress bar
import 'nprogress/nprogress.css' // progress bar style

NProgress.configure({ showSpinner: false }) // NProgress Configuration


router.beforeEach(async(to, from, next) => {
  // start progress bar
  NProgress.start()
  // const url = window.location.href
  // console.log(url);
  next()
})

router.afterEach(() => {
  // finish progress bar
  NProgress.done()
})
