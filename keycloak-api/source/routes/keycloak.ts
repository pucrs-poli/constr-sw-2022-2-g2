import express from "express";
import controller from "../controllers/keycloak";
const router = express.Router();

router.post("/login/:realm", controller.login);
router.get("/userinfo/:realm", controller.userInfo);
router.get("/users/:realm", controller.getUsers);
router.get("/users/:realm/:id", controller.getUserById);
router.post("/users/:realm/:id", controller.createUser);
router.delete("/users/:realm/:id", controller.deleteUser);
router.put("/users/:realm/:id", controller.updateUserData);
router.patch("/users/:realm/:id", controller.updateUserPassword);

export = router;
