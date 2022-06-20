
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

const lastCourse = new Vue({
  el: '#last-courses',
  data() {
    return {
      info: ['', '', '', '', '', ''],
      isLoaded: false
    };
  },
  mounted() {
    axios
        .get('/api/course?limit=6')
        .then(response => {
          this.info = response.data;
          this.isLoaded = true;
        })
        .catch(error => console.log(error));
  }
});

const categoryCourses = new Vue({
  el: '#category-courses',
  data() {
    return {
      info: ['', '', ''],
      isLoaded: false
    }
  },
  mounted() {
    axios
        .get('/api/course?limit=3')
        .then(response => {
          this.info = response.data;
          this.isLoaded = true;
        })
        .catch(error => console.log(error));
  }
});

const course = Vue.component('course',{
  props: ['course'],
  template: '<div class="card">' +
              '<div class="course-title-image">' +
                '<img :src="`${course.titlePhotoPath}`" class="course-image">' +
              '</div>' +
              '<a :href="`/pages/review.html?id=${course.id}`" class="course-title">{{ course.title }}</a>' +
            '</div>'
});