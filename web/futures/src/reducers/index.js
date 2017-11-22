const reduce = (state, action) => {
  switch (action.type) {
    case 'LOGIN_SUCCESS':
      return Object.assign({},state,{
          "uid": action.uid,
          "token": action.token
        })
    default:
      return state
  }
}

export default reduce