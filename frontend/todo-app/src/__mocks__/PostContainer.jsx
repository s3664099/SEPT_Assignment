export default class PostContainer {
    constructor() {
       
    }
  
    refreshPosts() {
      console.log('Mock_PostContainer: refreshPosts was called');
    }

    editPostButton(){
        console.log('Mock_PostContainer: refreshPosts was called');
    }

    deletePostButton(postID){
        console.log('delete post' + postID)
        let username = AuthenticationService.getLoggedInUserName()
        WallDataService.deletePost(username, postID)
        .then(response=>{
          this.refreshPosts()
        })
      }
    
      addPostClicked(){
        console.log("new post button clicked")
        this.props.history.push(`/wall/-1`)
      }
  }