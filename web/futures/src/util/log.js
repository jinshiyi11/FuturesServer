const DEBUG = process.env.NODE_ENV !== 'production'

export function log(message) {
  if (DEBUG) {
    console.log(message)
  }
}
