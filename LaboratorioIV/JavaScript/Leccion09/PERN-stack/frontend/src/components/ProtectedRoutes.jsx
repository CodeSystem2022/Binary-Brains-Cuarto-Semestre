import { Navigate, Outlet } from "react-router-dom"

// eslint-disable-next-line react/prop-types
export const ProtectedRoute = ({redirectTo, isAllowed, children}) =>{
    if(!isAllowed){
        return <Navigate to={redirectTo} replace />
    }
    return children ? children : <Outlet />
}