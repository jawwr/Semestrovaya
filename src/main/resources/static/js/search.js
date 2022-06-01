document.title = decodeURI(document.location.search.split('=')[1]);

new Vue({
    el: '#search',
    data(){
        return{
            input: decodeURI(document.location.search.split('=')[1])
        }
    },
    methods: {
        search: function(){
            window.location.href = `/pages/search.html?q=${this.input}`
        }
    }
})