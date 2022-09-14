import express from 'express';
import controller from '../controllers/keycloak';
const router = express.Router();

router.get('/getUser/:realm', controller.getUser);
router.post('/postUser', controller.addUser);

export = router;