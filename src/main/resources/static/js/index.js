const testData = [
  {
    "id":"1",
    "title":"title-1",
    "description":"description-1"
  },
  {
    "id":"2",
    "title":"title-2",
    "description":"description-2"
  },
  {
    "id":"3",
    "title":"title-3",
    "description":"description-3"
  },
  {
    "id":"4",
    "title":"title-4",
    "description":"description-4"
  },
  {
    "id":"5",
    "title":"title-5",
    "description":"description-5"
  },
  {
    "id":"6",
    "title":"title-6",
    "description":"description-6"
  }
]

new Vue({
  el: '#courses',
  data() {
    return {
      info: null
    };
  },
  mounted() {
    // this.info = testData;
    axios
        .get('/course?limit=6')
        .then(response => (this.info = response.data))
        .catch(response => (this.info = response.data));
  }
});

Vue.component('course',{
  props: ['course'],
  template: '<div class="course">' +
        '<div class="course-title">{{ course.title }}</div> <div class="course-description">{{ course.description }}</div>' +
      '</div>'
})

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

