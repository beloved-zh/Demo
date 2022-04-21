import {onMounted} from 'vue'

type Options = {
    el: string
}

export default function (options:Options):Promise<string> {
    return new Promise((resolve) => {
        onMounted(() => {
            let img:HTMLImageElement = document.querySelector(options.el) as HTMLImageElement
            console.log('========================')
            console.log(img)
            // 图片加载完毕调用转换 base64
            img.onload = () => {
                resolve(base64(img))
            }
        })

        const base64 = (el:HTMLImageElement) => {
            const canvas = document.createElement('canvas')
            canvas.width = el.width
            canvas.height = el.height
            const ctx = canvas.getContext('2d')
            ctx?.drawImage(el, 0, 0, canvas.width, canvas.height)
            return canvas.toDataURL('image/png');
        }
    })
}