import {PiniaPluginContext} from 'pinia'
import {toRaw} from 'vue'

const setStorage = (key: string, val: any) => {
  localStorage.setItem(key, JSON.stringify(val))
}

const getStorage = (key: string) => {
    return localStorage.getItem(key) ? JSON.parse(localStorage.getItem(key) as string) : {}
}

type Options = {
    key?: string
}

const DEFAULT_KEY = 'app'

const piniaPlugin = (options?: Options) => {
    return (context: PiniaPluginContext) => {
        console.log('context', context)
        const { store } = context
        const data = getStorage(`${options?.key ?? DEFAULT_KEY}-${store.$id}`)
        store.$subscribe(() => {
            setStorage(`${options?.key ?? DEFAULT_KEY}-${store.$id}`, toRaw(store.$state))
        })
        return {
            ...data
        }
    }
}

export {
    piniaPlugin
}
