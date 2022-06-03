const search = new Vue({
    el: '#search',
    data(){
        return{
            input: ''
        }
    },
    mounted() {
        this.input = decodeURI(document.location.search.split('=')[1]);
    },
    methods: {
        search: function(e){
            courses.search(this.input)
        }
    }
});

const courses = new Vue({
    el: '#courses',
    data() {
        return{
            info:['','','']
        }
    },
    mounted(){
        axios
            .get(`/course/search?parameter=${search.input}`)
            .then(response => {
                this.info = response.data;
            })
            .catch(error => console.log(error));
    },
    methods: {
        search: function (param){
            axios
                .get(`/course/search?parameter=${param}`)
                .then(response => {
                    this.info = response.data;
                })
                .catch(error => console.log(error));
        }
    }
});

Vue.component('course',{
    props: ['course'],
    template: '<div class="course">\n' +
        '                <div class="title-image">' +
        '                    <img :src="`${course.titlePhotoPath}`" class="course-image">' +
        '                </div>\n' +
        '                <a class="course-info">' +
        '                    <a :href="`/pages/review.html?id=${course.id}`" class="course-title">' +
        '                        {{course.title}}' +
        '                    </a>' +
        '                    <div class="course-description">\n' +
        '                        {{course.description}}' +
        '                    </div>' +
        '                </div>' +
        '            </div>'
});