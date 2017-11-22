// 是否使用代理
const USE_PROXY = true
// const HOST = 'http://hehedream.duapp.com'
const HOST = 'http://localhost:8081'

export function getHost(){
  return HOST
}

export function getLoginUrl(){
  return HOST+'/login'
}

export function getFeedListUrl(showTime = -1, pulldown = false) {
  let count = -30
  if (pulldown) {
    count = 30
  }
  return HOST + '/getfeeds?id=' + showTime + '&count=' + count + '&admin=shuai_xx_123456&ver=1.3&channel=default'
}

export function getAlbumPicsUrl(feedId) {
  return HOST + '/getalbumpics?feedid=' + feedId
}

export function getThumbImgUrl(content) {
  return getProxyUrl(JSON.parse(content).thumbImgUrl)
  // return 'http://hehedream.duapp.com/proxy.jsp?' + JSON.parse(content).thumbImgUrl
  // return 'https://bird.ioliu.cn/v1?url=' + JSON.parse(content).thumbImgUrl
}

export function getBigImgUrl(content) {
  return JSON.parse(content).bigImgUrl
  // return getProxyUrl(JSON.parse(content).bigImgUrl)
}

export function getVideoImgUrl(content) {
  return JSON.parse(content).videoThumbUrl
  // return getProxyUrl(JSON.parse(content).videoThumbUrl)
}

export function getWebVideoUrl(content) {
  return JSON.parse(content).webVideoUrl
}

export function getStartCrawlerUrl() {
  return HOST + '/crawler?action=start'
}

export function getStopCrawlerUrl() {
  return HOST + '/crawler?action=stop'
}

export function getCrawlerStatusUrl() {
  return HOST + '/crawler?action=status'
}

export function getCrawlerLogUrl(logStartIndex) {
  return HOST + '/crawler?action=log&start=' + logStartIndex
}

export function getProxyUrl(rawUrl) {
  if (USE_PROXY) {
    return 'http://hehedream.duapp.com/proxy.jsp?' + rawUrl
  } else {
    return rawUrl
  }
}

export function getJsonUrl(rawUrl) {
  if (USE_PROXY) {
    return 'https://bird.ioliu.cn/v1?url=' + rawUrl
  } else {
    return rawUrl
  }
}


