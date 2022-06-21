import {createPinia} from 'pinia'
import { piniaPlugin } from './piniaPlugin'

const pinia = createPinia()

pinia.use(piniaPlugin())

export default pinia