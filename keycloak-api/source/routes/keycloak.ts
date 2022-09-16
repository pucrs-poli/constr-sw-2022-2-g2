import express from 'express';
import controller from '../controllers/keycloak';
const router = express.Router();

router.post('/login/:realm', controller.login);

export = router;