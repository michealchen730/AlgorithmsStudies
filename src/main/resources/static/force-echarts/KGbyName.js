var myChart = echarts.init(document.getElementById('main'), 'macarons');
// 指定图表的配置项和数据
var option = {
    tooltip : {
        show : true,   //默认显示
        showContent:true, //是否显示提示框浮层
        trigger:'item',//触发类型，默认数据项触发
        triggerOn:'click',//提示触发条件，mousemove鼠标移至触发，还有click点击触发
        alwaysShowContent:false, //默认离开提示框区域隐藏，true为一直显示
        showDelay:0,//浮层显示的延迟，单位为 ms，默认没有延迟，也不建议设置。在 triggerOn 为 'mousemove' 时有效。
        hideDelay:200,//浮层隐藏的延迟，单位为 ms，在 alwaysShowContent 为 true 的时候无效。
        enterable:false,//鼠标是否可进入提示框浮层中，默认为false，如需详情内交互，如添加链接，按钮，可设置为 true。
        position:'right',//提示框浮层的位置，默认不设置时位置会跟随鼠标的位置。只在 trigger 为'item'的时候有效。
        confine:false,//是否将 tooltip 框限制在图表的区域内。外层的 dom 被设置为 'overflow: hidden'，或者移动端窄屏，导致 tooltip 超出外界被截断时，此配置比较有用。
        transitionDuration:0.4,//提示框浮层的移动动画过渡时间，单位是 s，设置为 0 的时候会紧跟着鼠标移动。
    },


    legend: { //=========图例（每种形状对应节点内容）
        show: true,
        data: [{
            name: '导弹',

            icon: 'rect'//'circle', 'rect', 'roundRect', 'triangle', 'diamond', 'pin', 'arrow'

        },
            {
                name: '长度',

                icon: 'roundRect'
            }, {
                name: '重量',

                icon: 'circle'
            }, {
                name: '射程',

                icon: 'circle'
            }, {
                name: '其他',
                icon: 'roundRect'
            }]
    },


    series : [ {
        type : 'graph', //关系图
        name : "弹道导弹知识图谱", //系列名称，用于tooltip的显示，legend 的图例筛选，在 setOption 更新数据和配置项时用于指定对应的系列。
        layout : 'force', //图的布局，类型为力导图，'circular' 采用环形布局，见示例 Les Miserables
        legendHoverLink : true,//是否启用图例 hover(悬停) 时的联动高亮。
        hoverAnimation : true,//是否开启鼠标悬停节点的显示动画
        coordinateSystem : null,//坐标系可选
        xAxisIndex : 0, //x轴坐标 有多种坐标系轴坐标选项
        yAxisIndex : 0, //y轴坐标
        force : { //力引导图基本配置
            //initLayout: ,//力引导的初始化布局，默认使用xy轴的标点
            repulsion : 100,//节点之间的斥力因子。支持数组表达斥力范围，值越大斥力越大。
            gravity : 0.03,//节点受到的向中心的引力因子。该值越大节点越往中心点靠拢。
            edgeLength :150,//边的两个节点之间的距离，这个距离也会受 repulsion。[10, 50] 。值越小则长度越长
            layoutAnimation : true
            //因为力引导布局会在多次迭代后才会稳定，这个参数决定是否显示布局的迭代动画，在浏览器端节点数据较多（>100）的时候不建议关闭，布局过程会造成浏览器假死。
        },
        roam : true,//是否开启鼠标缩放和平移漫游。默认不开启。如果只想要开启缩放或者平移，可以设置成 'scale' 或者 'move'。设置成 true 为都开启
        nodeScaleRatio : 0.6,//鼠标漫游缩放时节点的相应缩放比例，当设为0时节点不随着鼠标的缩放而缩放
        draggable : true,//节点是否可拖拽，只在使用力引导布局的时候有用。
        focusNodeAdjacency : true,//是否在鼠标移到节点上的时候突出显示节点以及节点的边和邻接节点。
        //symbol:'roundRect',//关系图节点标记的图形。ECharts 提供的标记类型包括 'circle'(圆形), 'rect'（矩形）, 'roundRect'（圆角矩形）, 'triangle'（三角形）, 'diamond'（菱形）, 'pin'（大头针）, 'arrow'（箭头）  也可以通过 'image://url' 设置为图片，其中 url 为图片的链接。'path:// 这种方式可以任意改变颜色并且抗锯齿
        //symbolSize:10 ,//也可以用数组分开表示宽和高，例如 [20, 10] 如果需要每个数据的图形大小不一样，可以设置为如下格式的回调函数：(value: Array|number, params: Object) => number|Array
        //symbolRotate:,//关系图节点标记的旋转角度。注意在 markLine 中当 symbol 为 'arrow' 时会忽略 symbolRotate 强制设置为切线的角度。
        //symbolOffset:[0,0],//关系图节点标记相对于原本位置的偏移。[0, '50%']
        edgeSymbol : [ 'none', 'none' ],//边两端的标记类型，可以是一个数组分别指定两端，也可以是单个统一指定。默认不显示标记，常见的可以设置为箭头，如下：edgeSymbol: ['circle', 'arrow']
        edgeSymbolSize : 10,//边两端的标记大小，可以是一个数组分别指定两端，也可以是单个统一指定。
        itemStyle : {//===============图形样式，有 normal 和 emphasis 两个状态。normal 是图形在默认状态下的样式；emphasis 是图形在高亮状态下的样式，比如在鼠标悬浮或者图例联动高亮时。
            normal : { //默认样式
                label : {
                    show : true
                },
                borderType : 'solid', //图形描边类型，默认为实线，支持 'solid'（实线）, 'dashed'(虚线), 'dotted'（点线）。
                borderColor : 'rgba(255,215,0,0.4)', //设置图形边框为淡金色,透明度为0.4
                borderWidth : 2, //图形的描边线宽。为 0 时无描边。
                opacity : 1
                // 图形透明度。支持从 0 到 1 的数字，为 0 时不绘制该图形。默认0.5

            },
            emphasis : {//高亮状态

            }
        },
        lineStyle : { //==========关系边的公用线条样式。
            normal : {
                color : 'rgba(255,0,255,0.4)',
                width : '3',
                type : 'solid', //线的类型 'solid'（实线）'dashed'（虚线）'dotted'（点线）
                curveness : 0.3, //线条的曲线程度，从0到1
                opacity : 1
                // 图形透明度。支持从 0 到 1 的数字，为 0 时不绘制该图形。默认0.5
            },
            emphasis : {//高亮状态

            }
        },
        label : { //=============图形上的文本标签
            normal : {
                show : true,//是否显示标签。
                position : 'inside',//标签的位置。['50%', '50%'] [x,y]
                textStyle : { //标签的字体样式
                    color : '#cde6c7', //字体颜色
                    fontStyle : 'normal',//文字字体的风格 'normal'标准 'italic'斜体 'oblique' 倾斜
                    fontWeight : 'bolder',//'normal'标准'bold'粗的'bolder'更粗的'lighter'更细的或100 | 200 | 300 | 400...
                    fontFamily : 'sans-serif', //文字的字体系列
                    fontSize : 12, //字体大小
                }
            },
            emphasis : {//高亮状态

            }
        },
        edgeLabel : {//==============线条的边缘标签
            normal : {
                show : false
            },
            emphasis : {//高亮状态

            }
        },
        //别名为nodes   name:影响图形标签显示,value:影响选中后值得显示,category:所在类目的index,symbol:类目节点标记图形,symbolSize:10图形大小
        //label:标签样式。

        data : [
            // {id:260,name:dongfen,length:80,weight:80,range:80,tests:null},
            {
                id : 0,
                category : 0,
                name : 'dongfeng',
                symbol : 'roundRect',
                value : 20,
                symbolSize : 80
            },
            {
                id : 1,
                category : 1,
                name : '80',
                symbol : 'rect',
                value : 20,
                symbolSize : 60
            },
            {
                id : 2,
                category : 2,
                name : '80',
                symbol : 'circle',
                value : 20,
                symbolSize : 60
            },
            {
                id : 3,
                category : 3,
                name : '80',
                symbol : 'circle',
                value : 20,
                symbolSize : 60
            }

        ],
        categories : [ //symbol name：用于和 legend 对应以及格式化 tooltip 的内容。 label有效
            {
                name : '导弹',
                symbol : 'rect',
                label : { //标签样式
                }
            }, {
                name : '长度',
                symbol : 'rect'
            }, {
                name : '重量',
                symbol : 'roundRect'
            }, {
                name : '射程',
                symbol : 'roundRect'
            }, {
                name : '其他',
                symbol : 'roundRect'
            } ],
        links : [ //edges是其别名代表节点间的关系数据。
            {
                source : 1,
                target : 0,
                // value:35,
                label: {
                    normal: {
                        show: true,
                        formatter:'长度'
                    }
                }
                // lineStyle: {
                //     normal: {
                //         width: 5,
                //         length:45,
                //     }
                // }
            },

            {source : 2, target : 0,
                label: {
                    normal: {
                        show: true,
                        formatter:'重量'
                    }
                }
            },
            {source : 3, target : 0,
                label: {
                    normal: {
                        show: true,
                        formatter:'射程'
                    }
                }
            },
            {source : 4, target : 0},
            {source : 5, target : 0}
        ]

    }]
};

// 使用刚指定的配置项和数据显示图表。
myChart.setOption(option);

