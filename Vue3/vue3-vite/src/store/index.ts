import { useTestStore } from './modules/user'

const store: any = {}

export const registerStore = () => {
	store.userStore = useTestStore()
}

export default store