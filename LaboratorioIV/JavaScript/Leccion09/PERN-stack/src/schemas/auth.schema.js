import { z } from 'zod';

export const signupSchema = z.object({
    name: z.string({
        required_error: "El nombre es requerido",
        invalid_type_error: "El nombre debe ser un string",
    }).min(1, {
        message: "El nombre debe tener al menos un caracter",
    }).max(255, {
        message: "El nombre debe tener como máximo 255 caracteres",
    }),
    email: z.string({
        required_error: "El email es requerido",
        invalid_type_error: "El email debe ser un string",
    }).min(1, {
        message: "El email debe tener al menos un caracter",
    }).max(255, {
        message: "El email debe tener como máximo 255 caracteres",
    }).optional(),
    password: z.string({
        required_error: "La contraseña es requerida",
        invalid_type_error: "La contraseña debe ser un string",
    }).min(1, {
        message: "La contraseña debe tener al menos un caracter",
    }).max(255, {
        message: "La contraseña debe tener como máximo 255 caracteres",
    }),
});

export const signinSchema = z.object({
    name: z.string({
        required_error: "El nombre es requerido",
        invalid_type_error: "El nombre debe ser un string",
    }).min(1, {
        message: "El nombre debe tener al menos un caracter",
    }).max(255, {
        message: "El nombre debe tener como máximo 255 caracteres",
    }),
    email: z.string({
        required_error: "El email es requerido",
        invalid_type_error: "El email debe ser un string",
    }).min(1, {
        message: "El email debe tener al menos un caracter",
    }).max(255, {
        message: "El email debe tener como máximo 255 caracteres",
    }).optional(),
    password: z.string({
        required_error: "La contraseña es requerida",
        invalid_type_error: "La contraseña debe ser un string",
    }).min(1, {
        message: "La contraseña debe tener al menos un caracter",
    }).max(255, {
        message: "La contraseña debe tener como máximo 255 caracteres",
    }),
});