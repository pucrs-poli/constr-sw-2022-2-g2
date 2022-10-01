import express from "express";
import controller from "../controllers/keycloak";
const router = express.Router();

router.post("/login", controller.login);
router.get("/userinfo", controller.userInfo);
router.get("/users", controller.getUsers);
router.get("/users/:id", controller.getUserById);
router.post("/users", controller.createUser);
router.delete("/users/:id", controller.deleteUser);
router.put("/users/:id", controller.updateUserData);
router.patch("/users/:id", controller.updateUserPassword);

export = router;
