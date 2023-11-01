import {forwardRef} from "react"

// eslint-disable-next-line react/display-name
export const Input = forwardRef((props, ref) => {
  return (
    <input type="text" className="bg-zinc-800 p-3 py-2 block my-2 w-full"
    {...props} ref={ref} />
 )
    
})
export default Input

