<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=GBK"/>
    <meta http-equiv="Content-Style-Type" content="text/css"/>
    <title>个人征信报告</title>
    <style type='text/css'>
        body {
            font-family: SimSun;
            padding-top: 50px;
        }

        @page {
            size: a4;
            @top-center {
                content: element(header);
            }
            @bottom-center {
                content: element(footer);
            }

        }

        div.header {
            display: block;
            /*text-align: center;*/
            position: running(header);
            width: 100%;
        }

        div.footer {
            display: block;
            text-align: center;
            position: running(footer);
            width: 100%;
        }

        .custom-page-start {
            margin-top: 50px;
        }

        table {
            border-collapse: collapse;
            margin: 0 auto;
            width: 100%;
        }

        td {
            border: #000000 solid 0.75pt;
            vertical-align: top;
            padding: 5pt;
        }

        p {
            line-height: 18pt;
            margin: 0pt 0pt 4pt;
        }

        span {
            font-size: 10pt;
        }

        @media print {
            table {
                page-break-after: auto
            }

            tr {
                page-break-inside: avoid;
                page-break-after: auto
            }

            td {
                page-break-inside: avoid;
                page-break-after: auto
            }

            thead {
                display: table-header-group
            }

            tfoot {
                display: table-footer-group
            }
        }
    </style>
</head>
<body>
<div class="header">
    <img src="${headerImage}" width="100" style="text-align:left; vertical-align: middle"/>
    <span style="float: right;">个人征信报告</span>
</div>
<div>
    <p>
        <span>&#xa0;</span>
    </p>
    <p>
        <span>&#xa0;</span>
    </p>
    <p>
        <span>&#xa0;</span>
    </p>
    <p>
        <span>&#xa0;</span>
    </p>
    <div style="text-align:center; vertical-align:middle;">
        <img src="${logoImage}" width="204"/>
    </div>
    <p style="text-align: center;">
        <span style="font-size: 26pt; font-weight: bold">御狗*嗅查</span>
    </p>
    <p>
        <span>&#xa0;</span>
    </p>
    <p>
        <span>&#xa0;</span>
    </p>
    <p style="text-align: center;">
        <span style="font-size: 48pt; font-weight: bold">个人征信报告</span>
    </p>
    <p>
        <span>&#xa0;</span>
    </p>
    <p>
        <span>&#xa0;</span>
    </p>
    <p>
        <span>&#xa0;</span>
    </p>
    <p style="text-align: center;">
        <span>报告生成日期：${reportDate}</span>
    </p>
    <#--<p style="margin: 0pt">-->
    <#--<div style="page-break-before: always; clear: both"/>-->
    <#--</p>-->
    <#-- <img src="headerPath" width="602" height="36"
          style="-aw-left-pos: 36.75pt; -aw-rel-hpos: column; -aw-rel-vpos: paragraph; -aw-top-pos: 0.5pt; -aw-wrap-type: none; margin-left: 36.75pt; margin-top: 0.5pt; position: absolute; z-index: 1"/>-->
    <p>
        <span>&#xa0;</span>
    </p>
    <p>
        <span>&#xa0;</span>
    </p>
    <p>
        <span>&#xa0;</span>
    </p>
    <p>
        <span>&#xa0;</span>
    </p>
    <div style="page-break-before: always; clear: both"/>
    <div>
        <p style="text-align:center;">
        <h1>报告说明</h1>
        </p>
        <p><span>&#xa0;</span></p>
        <p><span>&#xa0;</span></p>
        <span style="font-size: 21px">
        &#xa0;&#xa0;&#xa0;&#xa0;1.	本报告的知识产权等一切相关权益归属于滨海（天津）金融资产交易中心股份有限公司（以下简称“滨海金融”）。<br/><br/>
        &#xa0;&#xa0;&#xa0;&#xa0;2.	未经滨海金融的书面同意，不得对本报告擅自进行复制、摘录、编辑、转载、批露和发表等行为。<br/><br/>
        &#xa0;&#xa0;&#xa0;&#xa0;3.	您承诺并保证在查询信息及使用本报告前，已经获得了信息主体的充分授权，滨海金融不承担因未授权或授权不充分引起的任何责任，如对未获得信息主体的充分授权而进行查询并使用本报告的，全部责任及风险由您承担，由此给滨海金融造成损失的，您应负责赔偿。<br/><br/>
        &#xa0;&#xa0;&#xa0;&#xa0;4.	在本报告中的信息由滨海金融相关数据来源合作机构提供，滨海金融不保证其真实、准确、完整、客观及时效性，仅对信息进行如实整合及展示。滨海金融对本报告的使用不承担任何责任。<br/><br/>
        &#xa0;&#xa0;&#xa0;&#xa0;5.	报告信息自查询之日起24小时内有效，请以查询当天数据为准。<br/><br/>
        &#xa0;&#xa0;&#xa0;&#xa0;6.	本报告仅限滨海金融及合作方内部使用，请妥善保管本报告，并注意保密，不得披露、透露、泄露给任何第三方，亦不得用于除与滨海金融合作事项外其他用途。滨海金融不承担由于此报告泄露所带来的任何法律责任及纠纷。<br/><br/>
    </span>
        <p style="margin: 0pt">
        <div style="page-break-before: always; clear: both"/>
        </p>
    </div>
    <h1>
        <span style="font-size: 16pt; font-weight: bold">1.基本信息</span>
    </h1>
    <table>
        <tr>
            <td style="background-color:#f1f1f1; text-align:center">
                <p><span>姓名</span></p>
            </td>
            <td style="width:75pt; text-align:center">
                <p><span>${(personInfo.name)!'-'}</span></p>
            </td>
            <td style="background-color:#f1f1f1; text-align:center ">
                <p><span>性别</span></p>
            </td>
            <td style="width:75pt; text-align: center">
                <p><span>${(personInfo.sex)!'-'}</span></p>
            </td>
            <td style="background-color:#f1f1f1; text-align:center ">
                <p><span>年龄</span></p>
            </td>
            <td style="width:75pt; text-align: center">
                <p><span>${(personInfo.age)!'-'}</span></p>
            </td>
        </tr>
    </table>
    <p>
        <span>&#xa0;</span>
    </p>
    <h1>
        <span style="font-size: 16pt; font-weight: bold">2.欺诈风险</span>
    </h1>
    <h2>
        <span style="font-size: 14pt; font-weight: bold">2.1 欺诈分评估</span>
    </h2>
    <p>
        <!-- width="668" height="312"-->
        <#-- <img src="antiFraudEchartsPath"
              style="-aw-left-pos: 0pt; -aw-rel-hpos: column; -aw-rel-vpos: paragraph; -aw-top-pos: 0pt; -aw-wrap-type: inline"/>-->
    </p>
    <table>
        <tr>
            <td style="background-color: #f2f2f2; text-align:center; width: 56.25pt">
                <p>
                    <span>序号</span>
                </p>
            </td>
            <td style="background-color: #f2f2f2; text-align:center; width: 190.65pt">
                <p>
                    <span>类型</span>
                </p>
            </td>
            <td style="background-color: #f2f2f2; text-align:center; width: 135.35pt">
                <p>
                    <span>分值</span>
                </p>
            </td>
            <td style="background-color: #f2f2f2; text-align:center; width: 89pt">
                <p>
                    <span>建议</span>
                </p>
            </td>
        </tr>
        <#if antiFraudList??&& (antiFraudList?size&gt;0)>
        <#list antiFraudList as antiFraud>
            <tr>
                <td style="text-align: center">
                    <p>
                        <span>${antiFraud_index+1}</span>
                    </p>
                </td>
                <td style="text-align: center">
                    <p>
                        <span>${(antiFraud.channelName)!'暂无数据'}</span>
                    </p>
                </td>
                <td style="text-align: center">
                    <p>
                        <span>${(antiFraud.antiFraudscore)!'暂无数据'}</span>
                    </p>
                </td>
                <td style="text-align: center">
                    <p>
                        <span>${(antiFraud.decision)!'暂无数据'}</span>
                    </p>
                </td>
            </tr>
        </#list>
    </table>
    <p>
        <span>欺诈分值均介于0~100之间，分值越高，代表欺诈风险越高</span>
    </p>
    <#if antiFraudList?? && (antiFraudList?size==100)>
        <p>
            <span>该项数据量较大，如需查看更多数据，请在线查看相关信息。</span>
        </p>
    </#if>
<#else>
    <tr>
        <td colspan="4">
            <p style="text-align:center;"><span>暂无数据</span></p>
        </td>
    </tr>
    </table>
    </#if>
    <h2>
        <span style="font-size: 14pt; font-weight: bold">2.2 欺诈命中详情</span>
    </h2>
    <table>
        <tr>
            <td colspan="3">
                <p>
                    <span style="font-size: 12pt; font-weight: bold">腾讯(共命中</span>
                    <span style="color: #ff0000; font-size: 12pt; font-weight: bold">
                        <#if (hitRiskDetailList)??>
                            ${(hitRiskDetailList)?size}
                        <#else >
                            0
                        </#if>
                        </span>
                    <span style="font-size: 12pt; font-weight: bold">项)</span>
                </p>
            </td>
        </tr>
        <tr>
            <td style="background-color: #f2f2f2; text-align: center; width: 56.25pt">
                <p>
                    <span>序号</span>
                </p>
            </td>
            <td style="background-color: #f2f2f2; text-align:center; width: 190.65pt">
                <p>
                    <span>命中风险项</span>
                </p>
            </td>
            <td style="background-color: #f2f2f2; text-align:center; width: 135.35pt">
                <p>
                    <span>风险详情</span>
                </p>
            </td>
        </tr>
        <#if hitRiskDetailList??&& (hitRiskDetailList?size&gt;0)>
        <#list hitRiskDetailList as hitRiskDetail>
            <tr>
                <td style="text-align: center">
                    <p>
                        <span>${hitRiskDetail_index+1}</span>
                    </p>
                </td>
                <td style="text-align: center">
                    <p>
                        <span>${(hitRiskDetail.riskItem)!'暂无数据'}</span>
                    </p>
                </td>
                <td>
                    <p>
                        <span>${(hitRiskDetail.riskDetail)!'暂无数据'}</span>
                    </p>
                </td>
            </tr>
        </#list>

    </table>
    <#if hitRiskDetailList?? && (hitRiskDetailList?size==100)>
        <p>
            <span>该项数据量较大，如需查看更多数据，请在线查看相关信息。</span>
        </p>
    </#if>
<#else>
    <tr>
        <td colspan="3">
            <p style="text-align:center;"><span>暂无数据</span></p>
        </td>
    </tr>
    </table>
    </#if>

    <h2>
        <span style="font-size: 14pt; font-weight: bold">2.3 百行黑名单</span>
    </h2>
    <table>
        <tr>
            <td style="background-color:#f1f1f1; text-align:center">
                <p><span>序号</span></p>
            </td>
            <td style="background-color:#f1f1f1; text-align:center">
                <p><span>黑名单</span></p>
            </td>
            <td style="background-color:#f1f1f1; text-align:center">
                <p><span>是否命中</span></p>
            </td>
        </tr>
        <#if bhAnti.p2pEscapeDebtStatus??||bhAnti.supremeCourtExecutedStatus??||bhAnti.maxOverdueStatus??||bhAnti.multiPartyLoanStatus??>
        <tr>
            <td style="width:65pt; text-align:center">
                <p><span>1</span></p>
            </td>
            <td style="width:75pt; text-align:center">
                <p><span>是否在P2P逃废债名单</span></p>
            </td>
            <td style="width:75pt; text-align:center">
                <p><span>${(bhAnti.p2pEscapeDebtStatus)!'-'}</span></p>
            </td>
        </tr>
        <tr>
            <td style="width:65pt; text-align:center">
                <p><span>2</span></p>
            </td>
            <td style="width:75pt; text-align:center">
                <p><span>是否在高法执行人名单</span></p>
            </td>
            <td style="width:75pt; text-align:center">
                <p><span>${(bhAnti.supremeCourtExecutedStatus)!'-'}</span></p>
            </td>
        </tr>
        <tr>
            <td style="width:65pt; text-align:center">
                <p><span>3</span></p>
            </td>
            <td style="width:75pt; text-align:center">
                <p><span>近24月是否有严重逾期信息</span></p>
            </td>
            <td style="width:75pt; text-align:center">
                <p><span>${(bhAnti.maxOverdueStatus)!'-'}</span></p>
            </td>
        </tr>
        <tr>
            <td style="width:65pt; text-align:center">
                <p><span>4</span></p>
            </td>
            <td style="width:75pt; text-align:center">
                <p><span>近90天是否有多头借贷信息</span></p>
            </td>
            <td style="width:75pt; text-align:center">
                <p><span>${(bhAnti.multiPartyLoanStatus)!'-'}</span></p>
            </td>
        </tr>

    </table>
    <#else>
        <tr>
            <td colspan="3">
                <p style="text-align:center;"><span>暂无数据</span></p>
            </td>
        </tr>
        </table>
    </#if>

    <div style="page-break-before: always; clear: both"/>
    <h1>
        <span style="font-size: 16pt; font-weight: bold">3.司法信息</span>
    </h1>
    <h2>
        <span style="font-size: 14pt; font-weight: bold">3.1涉案信息</span>
    </h2>
    <table>
        <tr>
            <td colspan="4">
                <p>
                    <span style="font-size: 12pt; font-weight: bold">涉案数量统计</span>
                </p>
            </td>
        </tr>
        <#if caseCount??|| locationInvolved?? || timeInvolved?? ||reasonForTheCase??||closingMethod??>
        <tr>
            <td style="background-color: #f2f2f2; width: 114.55pt">
                <p>
                    <span>案件总数</span>
                </p>
            </td>
            <td style="width: 112.75pt">
                <p>
                    <span>${(caseCount.countTotal)!'0'}</span>
                </p>
            </td>
            <td style="background-color: #f2f2f2; width: 88.85pt">
                <p>
                    <span>已结案总数</span>
                </p>
            </td>
            <td style="width: 160.25pt">
                <p>
                    <span>${(caseCount.countJieTotal)!'0'}</span>
                </p>
            </td>
        </tr>
        <tr>
            <td style="background-color: #f2f2f2;">
                <p>
                    <span>未结案总数</span>
                </p>
            </td>
            <td>
                <p>
                    <span>${(caseCount.countWeiTotal)!'0'}</span>
                </p>
            </td>
            <td style="background-color: #f2f2f2;">
                <p>
                    <span>原告总数</span>
                </p>
            </td>
            <td>
                <p>
                    <span>${(caseCount.countYuangao)!'0'}</span>
                </p>
            </td>
        </tr>
        <tr>
            <td style="background-color: #f2f2f2;">
                <p>
                    <span>原告已结案总数</span>
                </p>
            </td>
            <td>
                <p>
                    <span>${(caseCount.countJieYuangao)!'0'}</span>
                </p>
            </td>
            <td style="background-color: #f2f2f2;">
                <p>
                    <span>原告未结案总数</span>
                </p>
            </td>
            <td>
                <p>
                    <span>${(caseCount.countWeiYuangao)!'0'}</span>
                </p>
            </td>
        </tr>
        <tr>
            <td style="background-color: #f2f2f2;">
                <p>
                    <span>被告总数</span>
                </p>
            </td>
            <td>
                <p>
                    <span>${(caseCount.countBeigao)!'0'}</span>
                </p>
            </td>
            <td style="background-color: #f2f2f2;">
                <p>
                    <span>被告未结案总数</span>
                </p>
            </td>
            <td>
                <p>
                    <span>${(caseCount.countWeiBeigao)!'0'}</span>
                </p>
            </td>
        </tr>
        <tr>
            <td style="background-color: #f2f2f2;">
                <p>
                    <span>第三人总数</span>
                </p>
            </td>
            <td>
                <p>
                    <span>${(caseCount.countOther)!'0'}</span>
                </p>
            </td>
            <td style="background-color: #f2f2f2;">
                <p>
                    <span>第三人已结案总数</span>
                </p>
            </td>
            <td>
                <p>
                    <span>${(caseCount.countJieOther)!'0'}</span>
                </p>
            </td>
        </tr>
        <tr>
            <td style="background-color: #f2f2f2;">
                <p>
                    <span>第三人未结案总数</span>
                </p>
            </td>
            <td colspan="3">
                <p>
                    <span>${(caseCount.countWeiOther)!'0'}</span>
                </p>
            </td>
        </tr>
        <tr>
            <td style="background-color: #f2f2f2;">
                <p>
                    <span>涉案地点分布</span>
                </p>
            </td>
            <td colspan="3">
                <p>
                    <span>${(locationInvolved)!'-'}</span>
                </p>
            </td>
        </tr>
        <tr>
            <td style="background-color: #f2f2f2;">
                <p>
                    <span>立案时间分布</span>
                </p>
            </td>
            <td colspan="3">
                <p>
                    <span>${(timeInvolved)!'-'}</span>
                </p>
            </td>
        </tr>
        <tr>
            <td style="background-color: #f2f2f2;">
                <p>
                    <span>案由分布</span>
                </p>
            </td>
            <td colspan="3">
                <p>
                    <span>${(reasonForTheCase)!'-'}</span>
                </p>
            </td>
        </tr>
        <tr>
            <td style="background-color: #f2f2f2;">
                <p>
                    <span>结案方式分布</span>
                </p>
            </td>
            <td colspan="3">
                <p>
                    <span>${(closingMethod)!'-'}</span>
                </p>
            </td>
        </tr>
    </table>
<#else>
    <tr>
        <td colspan="4">
            <p>
                <span style="text-align:center;">暂无数据</span>
            </p>
        </td>
    </tr>
    </table>
    </#if>
    <p>
        <span>&#xa0;</span>
    </p>
    <table>
        <tr>
            <td colspan="4">
                <p>
                    <span style="font-size: 12pt; font-weight: bold">涉案金额统计</span>
                </p>
            </td>
        </tr>
        <#if amountInvolved??>
        <tr>
            <td style="background-color: #f2f2f2; width: 99.6pt">
                <p>
                    <span>涉案总金额</span>
                </p>
            </td>
            <td style="width: 110.95pt">
                <p>
                    <span>${(amountInvolved.moneyTotal)!'-'}</span>
                </p>
            </td>
            <td style="background-color: #f2f2f2; width: 96.15pt">
                <p>
                    <span>已结案金额</span>
                </p>
            </td>
            <td style="width: 174.05pt">
                <p>
                    <span>${(amountInvolved.moneyJieTotal)!'-'}</span>
                </p>
            </td>
        </tr>
        <tr>
            <td style="background-color: #f2f2f2;">
                <p>
                    <span>未结案金额</span>
                </p>
            </td>
            <td>
                <p>
                    <span>${(amountInvolved.moneyWeiTotal)!'-'}</span>
                </p>
            </td>
            <td style="background-color: #f2f2f2;">
                <p>
                    <span>原告总金额</span>
                </p>
            </td>
            <td>
                <p>
                    <span>${(amountInvolved.moneyYuangao)!'-'}</span>
                </p>
            </td>
        </tr>
        <tr>
            <td style="background-color: #f2f2f2;">
                <p>
                    <span>原告已结案金额</span>
                </p>
            </td>
            <td>
                <p>
                    <span>${(amountInvolved.moneyJieYuangao)!'-'}</span>
                </p>
            </td>
            <td style="background-color: #f2f2f2;">
                <p>
                    <span>原告未结案金额</span>
                </p>
            </td>
            <td>
                <p>
                    <span>${(amountInvolved.moneyWeiYuangao)!'-'}</span>
                </p>
            </td>
        </tr>
        <tr>
            <td style="background-color: #f2f2f2;">
                <p>
                    <span>被告金额</span>
                </p>
            </td>
            <td>
                <p>
                    <span>${(amountInvolved.moneyBeigao)!'-'}</span>
                </p>
            </td>
            <td style="background-color: #f2f2f2;">
                <p>
                    <span>被告已结案金额</span>
                </p>
            </td>
            <td>
                <p>
                    <span>${(amountInvolved.moneyJieBeigao)!'-'}</span>
                </p>
            </td>
        </tr>
        <tr>
            <td style="background-color: #f2f2f2;">
                <p>
                    <span>被告未结案金额</span>
                </p>
            </td>
            <td>
                <p>
                    <span>${(amountInvolved.moneyWeiBeigao)!'-'}</span>
                </p>
            </td>
            <td style="background-color: #f2f2f2;">
                <p>
                    <span>第三人总金额</span>
                </p>
            </td>
            <td>
                <p>
                    <span>${(amountInvolved.moneyOther)!'-'}</span>
                </p>
            </td>
        </tr>
        <tr>
            <td style="background-color: #f2f2f2;">
                <p>
                    <span>第三人已结案金额</span>
                </p>
            </td>
            <td>
                <p>
                    <span>${(amountInvolved.moneyJieOther)!'-'}</span>
                </p>
            </td>
            <td style="background-color: #f2f2f2;">
                <p>
                    <span>第三人未结案金额</span>
                </p>
            </td>
            <td>
                <p>
                    <span>${(amountInvolved.moneyWeiOther)!'-'}</span>
                </p>
            </td>
        </tr>
        <tr>
            <td style="background-color: #f2f2f2;">
                <p>
                    <span>未结案金额比</span>
                </p>
            </td>
            <td colspan="3">
                <p>
                    <span>${(amountInvolved.moneyWeiPercent)!'-'}</span>
                </p>
            </td>
        </tr>
    </table>
<#else >
    <tr>
        <td colspan="4">
            <p>
                <span style="text-align:center;">暂无数据</span>
            </p>
        </td>
    </tr>
    </table>
    </#if>
    <p>
        <span>&#xa0;</span>
    </p>
    <h2>
        <span style="font-size: 14pt; font-weight: bold">3.2案件明细</span>
    </h2>
    <table>
        <tr>
            <td colspan="6">
                <p>
                    <span style="font-size: 12pt; font-weight: bold">刑事案件(共</span>
                    <span style="color: #ff0000; font-size: 12pt; font-weight: bold">
                        <#if (criminal)??>
                            ${(criminal)?size}
                        <#else >
                            0
                        </#if>
                        </span>
                    <span style="font-size: 12pt; font-weight: bold">件)</span>
                </p>
            </td>
        </tr>
        <tr>
            <td style="background-color: #f2f2f2; text-align:center; width: 72.25pt">
                <p>
                    <span>案号</span>
                </p>
            </td>
            <td style="background-color: #f2f2f2; text-align:center; width: 72.5pt">
                <p>
                    <span>经办法院</span>
                </p>
            </td>
            <td style="background-color: #f2f2f2; text-align:center; width: 100.3pt">
                <p>
                    <span>案件进展阶段</span>
                </p>
            </td>
            <td style="background-color: #f2f2f2; text-align:center; width: 58.6pt">
                <p>
                    <span>立案时间</span>
                </p>
            </td>
            <td style="background-color: #f2f2f2; text-align:center; width: 72.5pt">
                <p>
                    <span>立案案由</span>
                </p>
            </td>
            <td style="background-color: #f2f2f2; text-align:center; width: 73.45pt">
                <p>
                    <span>判决结果</span>
                </p>
            </td>
        </tr>
        <#if (criminal)?? && (criminal)?size&gt;0>
        <#list (criminal) as criminalCases>
            <tr>
                <td>
                    <p>
                        <span>${(criminalCases.cah)!'-'}</span>
                    </p>
                </td>
                <td>
                    <p>
                        <span>${(criminalCases.njbfy)!'-'}</span>
                    </p>
                </td>
                <td>
                    <p>
                        <span>${(criminalCases.najjzjd)!'-'}</span>
                    </p>
                </td>
                <td>
                    <p>
                        <span>${(criminalCases.dlarq)!'-'}</span>
                    </p>
                </td>
                <td>
                    <p>
                        <span>${(criminalCases.nlaay)!'-'}</span>
                    </p>
                </td>
                <td>
                    <p>
                        <span>${(criminalCases.cgkwsPjjg)!'-'}</span>
                    </p>
                </td>
            </tr>
        </#list>
    </table>
    <#if criminal?? && (criminal?size==100)>
        <p>
            <span>该项数据量较大，如需查看更多数据，请在线查看相关信息。</span>
        </p>
    </#if>
<#else >
    <tr>
        <td colspan="6">
            <p>
                <span style="text-align:center;">暂无数据</span>
            </p>
        </td>
    </tr>
    </table>
    </#if>
    <p><span>&#xa0;</span></p>
    <p><span>&#xa0;</span></p>
    <table>
        <tr>
            <td colspan="6">
                <p>
                    <span style="font-size: 12pt; font-weight: bold">民事案件(共</span>
                    <span style="color: #ff0000; font-size: 12pt; font-weight: bold">
                        <#if (civil)??>
                            ${(civil)?size}
                        <#else >
                            0
                        </#if>
                        </span>
                    <span style="font-size: 12pt; font-weight: bold">件)</span>
                </p>
            </td>
        </tr>
        <tr>
            <td style="background-color: #f2f2f2; text-align:center; width: 74pt">
                <p>
                    <span>案号</span>
                </p>
            </td>
            <td style="background-color: #f2f2f2; text-align:center; width: 74.25pt">
                <p>
                    <span>经办法院</span>
                </p>
            </td>
            <td style="background-color: #f2f2f2; text-align:center; width: 102.6pt">
                <p>
                    <span>案件进展阶段</span>
                </p>
            </td>
            <td style="background-color: #f2f2f2; text-align:center; width: 60.1pt">
                <p>
                    <span>立案时间</span>
                </p>
            </td>
            <td style="background-color: #f2f2f2; text-align:center; width: 74.25pt">
                <p>
                    <span>立案案由</span>
                </p>
            </td>
            <td style="background-color: #f2f2f2; text-align:center; width: 75pt">
                <p>
                    <span>判决结果</span>
                </p>
            </td>
        </tr>
        <#if (civil)?? && (civil)?size&gt;0>
        <#list (civil) as civilCases>
            <tr>
                <td>
                    <p>
                        <span>${(civilCases.cah)!'-'}</span>
                    </p>
                </td>
                <td>
                    <p>
                        <span>${(civilCases.njbfy)!'-'}</span>
                    </p>
                </td>
                <td>
                    <p>
                        <span>${(civilCases.najjzjd)!'-'}</span>
                    </p>
                </td>
                <td>
                    <p>
                        <span>${(civilCases.dlarq)!'-'}</span>
                    </p>
                </td>
                <td>
                    <p>
                        <span>${(civilCases.nlaay)!'-'}</span>
                    </p>
                </td>
                <td>
                    <p>
                        <span>${(civilCases.cgkwsPjjg)!'-'}</span>
                    </p>
                </td>
            </tr>
        </#list>
    </table>
    <#if civil?? && (civil?size==100)>
        <p>
            <span>该项数据量较大，如需查看更多数据，请在线查看相关信息。</span>
        </p>
    </#if>
<#else >
    <tr>
        <td colspan="6">
            <p>
                <span style="text-align:center;">暂无数据</span>
            </p>
        </td>
    </tr>
    </table>
    </#if>

    <p><span>&#xa0;</span></p>
    <p><span>&#xa0;</span></p>
    <table>
        <tr>
            <td colspan="6">
                <p>
                    <span style="font-size: 12pt; font-weight: bold">行政案件(共</span>
                    <span style="color: #ff0000; font-size: 12pt; font-weight: bold">
                        <#if (administrative)??>
                            ${(administrative)?size}
                        <#else >
                            0
                        </#if>
                        </span>
                    <span style="font-size: 12pt; font-weight: bold">件)</span>
                </p>
            </td>
        </tr>
        <tr>
            <td style="background-color: #f2f2f2; text-align:center; width: 74pt">
                <p>
                    <span>案号</span>
                </p>
            </td>
            <td style="background-color: #f2f2f2; text-align:center; width: 74.25pt">
                <p>
                    <span>经办法院</span>
                </p>
            </td>
            <td style="background-color: #f2f2f2; text-align:center; width: 102.6pt">
                <p>
                    <span>案件进展阶段</span>
                </p>
            </td>
            <td style="background-color: #f2f2f2; text-align:center; width: 60.1pt">
                <p>
                    <span>立案时间</span>
                </p>
            </td>
            <td style="background-color: #f2f2f2; text-align:center; width: 74.25pt">
                <p>
                    <span>立案案由</span>
                </p>
            </td>
            <td style="background-color: #f2f2f2; text-align:center; width: 75pt">
                <p>
                    <span>判决结果</span>
                </p>
            </td>
        </tr>
        <#if (administrative)?? && (administrative)?size&gt;0>
        <#list (administrative) as administrativeCases>
            <tr>
                <td>
                    <p>
                        <span>${(administrativeCases.cah)!'-'}</span>
                    </p>
                </td>
                <td>
                    <p>
                        <span>${(administrativeCases.njbfy)!'-'}</span>
                    </p>
                </td>
                <td>
                    <p>
                        <span>${(administrativeCases.najjzjd)!'-'}</span>
                    </p>
                </td>
                <td>
                    <p>
                        <span>${(administrativeCases.dlarq)!'-'}</span>
                    </p>
                </td>
                <td>
                    <p>
                        <span>${(administrativeCases.nlaay)!'-'}</span>
                    </p>
                </td>
                <td>
                    <p>
                        <span>${(administrativeCases.cgkwsPjjg)!'-'}</span>
                    </p>
                </td>
            </tr>
        </#list>
    </table>
    <#if administrative?? && (administrative?size==100)>
        <p>
            <span>该项数据量较大，如需查看更多数据，请在线查看相关信息。</span>
        </p>
    </#if>
<#else >
    <tr>
        <td colspan="6">
            <p>
                <span style="text-align:center;">暂无数据</span>
            </p>
        </td>
    </tr>
    </table>
    </#if>

</div>
</body>
</html>
