require.config({
    packages:[{
        name:'echarts',
        location:'/force-echarts/echarts/src',
        main:'echarts'
    },{
        name:'zrender',
        location:'/force-echarts/zrender/src',
        main:'zrender'
    }]
});
var  option = {
    title : {
        text: '人物关系：乔布斯',
        subtext: '数据来自人立方',
        x:'right',
        y:'bottom'
    },
    tooltip : {
        trigger: 'item',
        formatter: '{a} : {b}'
    },
    legend: {
        x: 'left',
        selected:{'朋友':true,'家人':true},
        data:['家人','朋友']
    },
    isShowScrollBar:false,
    series: [
        {
            type:'kforce',
            categories : [
                {
                    name: '人物',
                    itemStyle: {
                        normal: {
                            color : '#ff7f50'
                        }
                    }
                },
                {
                    name: '家人',
                    itemStyle: {
                        normal: {
                            color : '#ff7f50'
                        }
                    }
                },
                {
                    name:'朋友',
                    itemStyle: {
                        normal: {
                            color : '#87cdfa'
                        }
                    }
                }
            ],
            itemStyle: {
                normal: {
                    label: {
                        show: true,
                        textStyle: {
                            color: '#000000'
                        }
                    },
                    nodeStyle : {
                        brushType : 'both',
                        strokeColor : 'rgba(255,215,0,0.4)',
                        lineWidth : 2
                    }
                },emphasis:{
                    linkStyle : { strokeColor : '#5182AB'}
                }
            },
            minRadius : 15,
            maxRadius : 25,
            density : 0.8,
            attractiveness: 0.8,
            nodes:[
                {category:0, name: '乔布斯', value : 10,shapeType:'rectangle',onclick:function(params){
                        alert(params.target.style.text);
                        params.target.style.text = "雷布斯";
                    },
                    itemStyle:{
                        normal:{
                            width:100,
                            height:80
                        }
                    }},
                {category:1, name: '丽萨-乔布斯',value : 2,shapeType:'ellipse',
                    itemStyle:{
                        normal:{
                            a:40,
                            b:20
                        }
                    }},
                {category:1, name: '保罗-乔布斯',value : 3},
                {category:1, name: '克拉拉-乔布斯',value : 3},
                {category:1, name: '劳伦-鲍威尔',value : 7},
                {category:2, name: '史蒂夫-沃兹尼艾克',value : 5},
                {category:2, name: '奥巴马',value : 8,shapeType:'rectangle'},
                {category:2, name: '比尔-盖茨',value : 3},
                {category:2, name: '乔纳森-艾夫',value : 4},
                {category:2, name: '蒂姆-库克',value : 4},
                {category:2, name: '龙-韦恩',value : 1},
            ],
            links : [
                {source : 1, target : 0, weight : 1,
                    onclick:function(params){
                        alert(params.target.style.text);
                    },
                    itemStyle:{
                        normal:{
                            lineWidth:10,
                            text:'丽萨-乔布斯',
                            textColor:'#030303',
                            textFont:'bold 15px verdana',
                            textPosition:'inside'
                        }
                    }},
                {source : 2, target : 0, weight : 2},
                {source : 3, target : 0, weight : 1},
                {source : 4, target : 0, weight : 2},
                {source : 5, target : 0, weight : 3},
                {source : 6, target : 0, weight : 6},
                {source : 7, target : 0, weight : 6},
                {source : 8, target : 0, weight : 1},
                {source : 9, target : 0, weight : 1},
                {source : 10, target : 0, weight : 1}

            ]
        }
    ]
};
require(
    [
        'echarts',
        'echarts/chart/kforce',
    ],
    function(ec) {
        var myChart = ec.init(document.getElementById('demo1'));
        myChart.setOption(option);
    }
)