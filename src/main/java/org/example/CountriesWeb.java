package org.example;

import org.example.service.CountryService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/process")
public class CountriesWeb extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("WebContent/index.html");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String inputText = request.getParameter("inputText");
        String inputText2 = request.getParameter("inputText2");
        String inputText3 = request.getParameter("inputText3");

        CountryService service = new CountryService();

        String countryName = null;
        if (inputText != null && !inputText.isEmpty()) {
            countryName = service.getCountryByIso(inputText.toUpperCase());
        }

        List<String> countriesName = null;
        if (inputText2 != null && !inputText2.isEmpty()) {
            countriesName = service.getCountriesByLetter(inputText2.toUpperCase());
        }

        String countryInfo = null;
        if (inputText3 != null && !inputText3.isEmpty()) {
            countryInfo = service.getCountryInfoByName(inputText3.toUpperCase());
        }

        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();


        if (countryName != null) {
            out.write(countryName);
        } else if (countriesName != null) {
            // Convert list of country names to a single string separated by commas
            out.write(String.join(", ", countriesName));
        } else if (countryInfo != null) {
            // Convert list of country names to a single string separated by commas
            out.write(String.join(", ", countryInfo));
        } else {
            out.write("bisey yaz sonra ara");
        }

        out.close();
    }
}
