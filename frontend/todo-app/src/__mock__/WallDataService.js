
const posts = {
    4: {postID: 1, ownerID:1, message:'hello world'},
    5: {postID: 2, ownerID:2, message:'hello testing'}
  };
  
  export default function retrievePost(url) {
    return new Promise((resolve, reject) => {
      const postID = parseInt(url.substr('/users/'.length), 10);
      process.nextTick(() =>
        posts[postID]
          ? resolve(post[postID])
          : reject({
              error: 'User with ' + postID + ' not found.',
            }),
      );
    });
  }