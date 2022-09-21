import express from "express";
import controller from "../controllers/keycloak";
const router = express.Router();

router.post("/login/:realm", controller.login);
router.get("/userinfo/:realm", controller.userInfo);
router.get("/users/:realm", controller.getUsers);
router.get("/users/:realm/:id", controller.getUserById);
router.delete("/users/:realm/:id", controller.deleteUser);

export = router;
