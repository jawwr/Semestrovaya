Vue.component('loadcard',{
  props: ['card'],
  template: '<div class="card" aria-hidden="true">' +
              '<div class="img-loaded"></div>' +
              '<div class="card-body">' +
                  '<p class="card-text placeholder-glow">' +
                      '<span class="placeholder col-7"></span>' +
                      '<span class="placeholder col-4"></span>' +
                      '<span class="placeholder col-4"></span>' +
                      '<span class="placeholder col-6"></span>' +
                      '<span class="placeholder col-8"></span>' +
                  '</p>' +
              '</div>' +
            '</div>'
});

var lastCourse = new Vue({
  el: '#last-courses',
  data() {
    return {
      info: ['','','','','',''],
      loaded: false
    };
  },
  mounted() {
    axios
        .get('/course?limit=6')
        .then(response => {
          this.info = response.data;
          this.loaded = true;
        })
        .catch(error => console.log(error));
  }
});

Vue.component('course',{
  props: ['course'],
  template: '<div class="card">' +
              '<div class="img-loaded"></div>' +
              '<a href="" class="course-title">{{ course.title }}</a>' +
            '</div>'
});

new Vue({
  el: '#search',
  data(){
    return{
      input:''
    }
  },
  methods: {
    search: function(){
        window.location.href = `/pages/search.html?q=${this.input}`
    }
  }
})

