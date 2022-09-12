import express from 'express';
import controller from '../controllers/keycloak';
const router = express.Router();

router.get('/getUser', controller.getUser);
router.post('/postUser', controller.addUser);

export = router;

// import express from 'express';
// import controller from '../controllers/keycloak';
// const router = express.Router();

// router.get('/posts', controller.getPosts);
// router.get('/posts/:id', controller.getPost);
// router.put('/posts/:id', controller.updatePost);
// router.delete('/posts/:id', controller.deletePost);
// router.post('/posts', controller.addPost);

// export = router;