new Vue({
    el:'#test',
    data(){
        return{
            message:''
        }
    },
    mounted() {
        axios.get(`/course/search?parameter=${document.location.search.split('=')[1]}`)
            .then(response => this.message = response.data)
            .catch(error => console.log(error))
    }
})