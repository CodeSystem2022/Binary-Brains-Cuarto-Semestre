import { Router } from "express";
import { listarTareas, listarTarea, crearTarea, actualizarTarea, eliminarTarea } from "../controllers/tareas.controller.js";

const router = Router();

router.get('/tareas', listarTareas);

router.get('/tareas/:id', listarTarea);

router.post('/tareas', crearTarea);

router.put('/tareas/:id', actualizarTarea);

router.delete('/tareas', eliminarTarea);

export default router;