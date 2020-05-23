<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=GBK"/>
    <meta http-equiv="Content-Style-Type" content="text/css"/>
    <title>学生信息报告</title>
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
<p>学生{(name)}信息:</p>
<p>年龄：{(age)}</p>
<p>性别：{(sex)}</p>
</body>
</html>
