var course = new Vue({
    el: '#course',
    data() {
        return{
            courseInfo : ''
        }
    },
    mounted(){
        axios
        .get(`/course/${document.location.search.split('=')[1]}`)
            .then(response => {
                this.courseInfo = response.data;
                document.title = this.courseInfo.title;
            })
            .catch(error => console.log(error));
    }
})
