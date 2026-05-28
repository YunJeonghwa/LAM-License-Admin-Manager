console.log("🔥 JS 파일 로드됨");
document.addEventListener('DOMContentLoaded', function() {
    console.log("🔥 DOM 로드됨");
    // -------------------------------------------------------
    // 1. 왼쪽: 월별 라이선스 증감 현황 (양수/음수 Bar Chart)
    // -------------------------------------------------------
    const fluctuationCanvas = document.getElementById('fluctuationChart');
    if (fluctuationCanvas) {
        new Chart(fluctuationCanvas, {
            type: 'bar',
            data: {
                labels: ['1월', '2월', '3월', '4월', '5월', '6월', '7월'],
                datasets: [
                    {
                        label: '구매 및 연장 (+)',
                        data: [15, 20, 35, 40, 25, 10, 50],
                        backgroundColor: 'rgba(54, 162, 235, 0.7)',
                        borderRadius: 4,
                    },
                    {
                        label: '미연장/이탈 (-)',
                        data: [-10, -25, -15, -30, -10, -40, -5],
                        backgroundColor: 'rgba(255, 99, 132, 0.7)',
                        borderRadius: 4,
                    }
                ]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                plugins: {
                    legend: { position: 'top' },
                    tooltip: {
                        callbacks: {
                            label: function(context) {
                                let label = context.dataset.label || '';
                                let value = context.raw;
                                return label + ': ' + Math.abs(value) + '건'; // 음수를 절댓값으로 표시
                            }
                        }
                    }
                },
                scales: {
                    y: {
                        beginAtZero: true,
                        grid: {
                            color: (context) => context.tick.value === 0 ? '#666' : '#e0e0e0',
                            lineWidth: (context) => context.tick.value === 0 ? 2 : 1
                        }
                    }
                }
            }
        });
    }

    // -------------------------------------------------------
    // 2. 오른쪽: 라이선스 타입별 비중 (Doughnut Chart)
    // -------------------------------------------------------
    async function drawTypeRatioChart() {
        const typeRatioCanvas = document.getElementById('typeRatioChart');

        //캔버스 없으면 함수 종료
        if (!typeRatioCanvas) return;

        // 백엔드에서 api 가져오기
        try {
            // 실제 백엔드 api 주소
            const response = await fetch('/api/license-stats')
            if (!response.ok) {
                throw new Error('서버에서 데이터를 가져오지 못했습니다.');
            }

            // 백엔드에서 넘겨준 JSON 데이터를 파싱합니다.
            const dbData = await response.json();
            console.log("dbData",dbData);

            // 2. Chart.js가 읽을 수 있게 데이터 가공하기
            // *주의: 백엔드에서 보내주는 JSON의 key 이름에 맞춰 'labelName'과 'countValue'를 수정하세요.
            // 예시: [{ labelName: 'STANDARD', countValue: 55 }, ...]
            const chartLabels = dbData.map(item => item.licenseType);
            const chartValues = dbData.map(item => item.count);

            console.log("labels:", chartLabels);
            console.log("values:", chartValues);

            new Chart(typeRatioCanvas, {
                type: 'doughnut',
                data: {
                    // 실제 서비스의 라이선스 종류로 변경해서 사용하세요
                    labels: chartLabels,
                    datasets: [{
                        data: chartValues, // 각 라이선스별 퍼센트 또는 개수
                        backgroundColor: [
                            'rgba(54, 162, 235, 0.8)',  // 파란색
                            'rgba(75, 192, 192, 0.8)',  // 민트색
                            'rgba(255, 206, 86, 0.8)'   // 노란색
                        ],
                        borderWidth: 1
                    }]
                },
                options: {
                    responsive: true,
                    maintainAspectRatio: false,
                    cutout: '65%', // 도넛 가운데 구멍 크기 조절 (퍼센트)
                    plugins: {
                        legend: {
                            position: 'bottom' // 도넛 차트는 범례를 아래에 두는 것이 예쁩니다
                        },
                        tooltip: {
                            callbacks: {
                                label: function (context) {
                                    let label = context.label || '';
                                    let value = context.raw;
                                    return label + ': ' + value + '건';
                                }
                            }
                        }
                    }
                }
            });
        } catch (error) {
            console.error('차트 렌더링 중 오류 발생:', error);
            // 필요하다면 여기에 "데이터를 불러올 수 없습니다" 같은 UI 처리 추가 가능
        }
    }

// 4. HTML(DOM)이 모두 로드된 후 차트 그리기 실행
   // document.addEventListener('DOMContentLoaded', drawTypeRatioChart);
    // 👉 여기서 바로 호출
    drawTypeRatioChart();
});