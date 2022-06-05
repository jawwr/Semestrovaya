Vue.component('loaded',{
    props: ['loaded'],
    template:   '<div class="course">' +
                    '<div class="img-loaded"></div>' +
                    '<div class="course-info">' +
                        '<p class="placeholder-wave">' +
                            '<span class="placeholder col-3 placeholder-lg me-1"></span>' +
                            '<span class="placeholder col-2 placeholder-lg me-1"></span>' +
                            '<span class="placeholder col-4 placeholder-lg"></span>' +
                        '</p>' +
                        '<hr>' +
                        '<div class="course-description">' +
                            '<p class="placeholder-wave">' +
                                '<span class="placeholder col-4 me-1"></span>' +
                                '<span class="placeholder col-7 me-1"></span>' +
                                '<span class="placeholder col-5 me-1"></span>' +
                                '<span class="placeholder col-3 me-1"></span>' +
                                '<span class="placeholder col-8 me-1"></span>' +
                                '<span class="placeholder col-2 me-1"></span>' +
                                '<span class="placeholder col-4 me-1"></span>' +
                                '<span class="placeholder col-3 me-1"></span>' +
                            '</p>' +
                        '</div>' +
                    '</div>' +
                '</div>'
});

Vue.component('course',{
    props: ['course'],
    template:   '<div class="course">' +
                    '<div class="title-image">' +
                    '   <img :src="`${course.titlePhotoPath}`" class="course-image">' +
                    '</div>' +
                    '<div class="course-info">' +
                        '<a :href="`/pages/review.html?id=${course.id}`" class="course-title">' +
                        '{{course.title}}' +
                        '</a>' +
                        '<hr>' +
                        '<div class="course-description">' +
                            '{{course.description}}' +
                        '</div>' +
                    '</div>' +
                '</div>'
});

const search = new Vue({
    el: '#search',
    data(){
        return{
            input: ''
        }
    },
    mounted() {
        this.input = document.location.search === '' ? '' : decodeURI(document.location.search.split('=')[1]);
    },
    methods: {
        search: function(e){
            courses.search(this.input);
        }
    }
});

const courses = new Vue({
    el: '#courses',
    data() {
        return{
            info:['','','',''],
            isLoaded: false
        }
    },
    mounted(){
        axios
            .get(`/course/search?parameter=${search.input}`)
            .then(response => {
                this.info = response.data;
                this.isLoaded = true;
            })
            .catch(error => console.log(error));
    },
    methods: {
        search: function (param){
            this.info = ['','','',''];
            this.isLoaded = false;
            axios
                .get(`/course/search?parameter=${param}`)
                .then(response => {
                    this.info = response.data;
                    this.isLoaded = true;
                })
                .catch(error => console.log(error));
        }
    }
});
