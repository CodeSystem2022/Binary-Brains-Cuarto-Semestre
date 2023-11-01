import  Router  from "express-promise-router";
import { listarTareas, listarTarea, crearTarea, actualizarTarea, eliminarTarea } from "../controllers/tareas.controller.js";

const router = Router();

router.get('/tareas', listarTareas);

router.get('/tareas/:id', listarTarea);

router.post('/tareas', crearTarea);

router.put('/tareas/:id', actualizarTarea);

router.delete('/tareas/:id', eliminarTarea);

export default router;