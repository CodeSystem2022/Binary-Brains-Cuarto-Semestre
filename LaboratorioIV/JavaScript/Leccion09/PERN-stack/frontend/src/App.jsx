import {Route, Routes} from 'react-router-dom'
import {Container} from "./components/ui"
import { ProtectedRoute } from './components/ProtectedRoutes'
import {useAuth} from "./context/AuthContext"

import Navbar from './components/navbar/Navbar'

import HomePage from './pages/HomePage'
import AboutPage from './pages/AboutPage'
import LoginPage from './pages/LoginPage'
import ProfilePage from './pages/ProfilePage'
import RegisterPage from './pages/RegisterPage'
import NotFound from './pages/NotFound'
import TareaFormPage from './pages/TareaFormPage'
import TareasPage from './pages/TareasPage'



function App(){
  const {isAuth} = useAuth();
  return(
   <>
   <Navbar/>
   <Container className="py-5">
   <Routes>
      <Route element={<ProtectedRoute isAllowed={!isAuth} redirectTo="/tareas"/>}>
        <Route path="/" element={<HomePage/>}/>
        <Route path="/about" element={<AboutPage/>}/>
        <Route path="/login" element={<LoginPage/>}/>
        <Route path="/register" element={<RegisterPage/>}/>
      </Route>
      <Route element={<ProtectedRoute isAllowed={isAuth} redirectTo="/login"/>}>
        <Route path="/perfil" element={<ProfilePage/>}/>
        <Route path="/tareas" element={<TareasPage/>}/>
        <Route path="/tareas/crear" element={<TareaFormPage/>}/>
        <Route path="/tareas/editar/:id" element={<TareaFormPage/>}/>
      </Route>
      <Route path="*" element={<NotFound/>}/>
    </Routes>
   </Container>
   </>
  )
}

export default App