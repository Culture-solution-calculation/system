package org.main.culturesolutioncalculation.service;

import org.main.culturesolutioncalculation.model.SolutionInfo;
public class HtmlGenerator {
    private String html;
    public String getHtmlFromA(Object[] a){
        String aHtml = "<html>" +
                "<body>" +
                "<table>" +
                "<tr>" +
                "<th class=\"category\">A액</th>" +
                "<th colspan=\"2\">기준량</th>" +
                "<th colspan=\"2\">원수성분</th>" +
                "<th colspan=\"2\">처방농도</th>" +
                "<th colspan=\"2\">100배액 기준</th>" +
                "</tr>";
        for (Object obj :  a){
            SolutionInfo solution = (SolutionInfo) obj;
            aHtml  += "<tr>" +
                    "<td class=\"name\">"+solution.getName()+"</td>" +
                    "<td>"+solution.getStandardAmount()+"</td>" +
                    "<td class=\"unit\">"+solution.getStdUnit()+"</td>" +
                    "<td>"+solution.getOriginComponent()+"</td>" +
                    "<td class=\"unit\">"+solution.getOriginUnit()+"</td>" +
                    "<td>"+solution.getPrescriptionConcentration()+"</td>" +
                    "<td class=\"unit\">"+solution.getPrescriptionUnit()+"</td>" +
                    "<td>"+String.format("%.2f",solution.getHundredfoldDilutionStandard())+"</td>" +
                    "<td class=\"unit\">"+solution.getHundredfoldUnit()+"</td>" +
                    "</tr>";
        }

        return aHtml;
    }

    public String getHtmlB(Object[] b){
        String bHtml = "<tr>" +
                "<th class=\"category\">B액</th>" +
                "<th colspan=\"2\">기준량</th>" +
                "<th colspan=\"2\">원수성분</th>" +
                "<th colspan=\"2\">처방농도</th>" +
                "<th colspan=\"2\">100배액 기준</th>" +
                "</tr>";
        for (Object obj :  b){
            SolutionInfo solution = (SolutionInfo) obj;
            bHtml  += "<tr>" +
                    "<td class=\"name\">"+solution.getName()+"</td>" +
                    "<td>"+solution.getStandardAmount()+"</td>" +
                    "<td class=\"unit\">"+solution.getStdUnit()+"</td>" +
                    "<td>"+solution.getOriginComponent()+"</td>" +
                    "<td class=\"unit\">"+solution.getOriginUnit()+"</td>" +
                    "<td>"+solution.getPrescriptionConcentration()+"</td>" +
                    "<td class=\"unit\">"+solution.getPrescriptionUnit()+"</td>" +
                    "<td>"+String.format("%.2f",solution.getHundredfoldDilutionStandard())+"</td>" +
                    "<td class=\"unit\">"+solution.getHundredfoldUnit()+"</td>" +
                    "</tr>";
        }
        return bHtml;
    }

    public String getHtmlC(Object[] c){
        String cHtml = "<tr>" +
                "<th class=\"category\">C액</th>" +
                "<th colspan=\"2\">기준량</th>" +
                "<th colspan=\"2\">원수성분</th>" +
                "<th colspan=\"2\">처방농도</th>" +
                "<th colspan=\"2\">100배액 기준</th>" +
                "</tr>";
        for (Object obj :  c){
            SolutionInfo solution = (SolutionInfo) obj;
            cHtml  += "<tr>" +
                    "<td class=\"name\">"+solution.getName()+"</td>" +
                    "<td>"+solution.getStandardAmount()+"</td>" +
                    "<td class=\"unit\">"+solution.getStdUnit()+"</td>" +
                    "<td>"+solution.getOriginComponent()+"</td>" +
                    "<td class=\"unit\">"+solution.getOriginUnit()+"</td>" +
                    "<td>"+solution.getPrescriptionConcentration()+"</td>" +
                    "<td class=\"unit\">"+solution.getPrescriptionUnit()+"</td>" +
                    "<td>"+String.format("%.2f",solution.getHundredfoldDilutionStandard())+"</td>" +
                    "<td class=\"unit\">"+solution.getHundredfoldUnit()+"</td>" +
                    "</tr>";
        }

        cHtml +="</table>" +
                "</body>" +
                "</html>";

        return cHtml;
    }

    public String getHtml(Object[] A, Object[] B, Object[] C){
        html = getHtmlFromA(A);
        html += getHtmlB(B);
        html += getHtmlC(C);
        return html;
    }
}
