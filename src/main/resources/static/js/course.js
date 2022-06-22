const page = Vue.component('page',{
    props:['page'],
    template:'<li v-on:click="activate()" class="page-item">'+
        '<span class="page-link">{{page.numberPage}}</span>' +
        '</li>',
    data(){
      return{
          pageNumber : this.$vnode.key - 1
      }
    },
    methods:{
        activate: function (){
            if (course.currentPage !== this.pageNumber){
                for (let i = 0; i < pageNumbers.length; i++){
                    if (pageNumbers[i].className === "page-item active"){
                        pageNumbers[i].className = "page-item";
                    }
                }
                this.$el.className = "page-item active";
                course.currentPage = this.pageNumber;
            }
        }
    },
    mounted() {
        if (this.pageNumber === 0){
            this.$el.className = "page-item active";
        }
    }
});

const pageInfo = Vue.component('info',{
    props:['info'],
    template:   '<div class="body">'+
                    '<div class="title">' +
                        '<h2>{{info.title}}</h2>' +
                    '</div>' +
                    '<div class="page-body">' +
                        '{{info.body}}' +
                    '</div>' +
                '</div>'
});

const pageNumbers = document.getElementsByClassName("page-item");

const course = new Vue({
    el:'#course',
    data(){
        return{
            courseInfo:'',
                // {
                //     id:"",
                //     name:"Тестовый курс",
                //     pages:[
                //         {
                //             numberPage: 1,
                //             title:"Первая страница",
                //             body:"Направлений соображения кадров играет в оценить интересный подготовки развития. Позиций, эксперимент равным занимаемых форм новая образом интересный модель заданий порядка, финансовых намеченных место количественный новая модель интересный участниками поставленных же же выполнять административных соображения нас повседневная место важную задача важные образом задача собой важные позволяет обучения структура структура развития. Финансовых направлений порядка, реализации структура равным существенных отношении направлений идейные прогрессивного постоянный же анализа количественный и постоянный а отношении плановых высшего практика существенных задания модель важную же условий административных сложившаяся постоянный таким представляет порядка, представляет образом модель и и задач. Административных идейные эксперимент идейные позволяет финансовых играет нашей направлений способствует ."
                //         },
                //         {
                //             numberPage: 2,
                //             title:"Вторая страница",
                //             body:"Содержание второй страницы"
                //         },
                //         {
                //             numberPage: 3,
                //             title:"Третья страница",
                //             body:"Содержание третей страницы"
                //         }
                //         ]
                // },
            currentPage : 0
        }
    },
    mounted() {
        axios
            .get(`/api/course/${document.location.search.split('=')[1]}`)
            .then(response => {
                this.courseInfo = response.data;
                console.log(this.courseInfo);
                document.title = this.courseInfo.title;
            })
            .catch(error => console.log(error));
    }

});