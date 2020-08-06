package janaswamy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * This is Client Side class which test the API's
 *
 * @Author Akhilesh Janaswamy
 * @version 1.0
 * @since 2020-08-06
 */
public class Main {

    /**
     * Main method to start the demp
     * @param args
     */
    public static void main(String[] args) {
        demo();
        System.out.println("Demo Done");
    }

    /**
     * This method is a demo which uses all API"S from the server side
     */
    public static void demo() {

        get("http://localhost:8081/customer/add/1/tim/tim33@gmail.com/1month");
        post("http://localhost:8081/customer/add");
        put("http://localhost:8081/customer/update");
        delete("http://localhost:8081/customer/delete/1");
        get("http://localhost:8081/customer/all");
        System.out.println("Demo Steps:\n Step1: Customer of ID 1 was been added using GET" +
                "\n Step 2: Customer of ID 2 was been added using POST" +
                "\n Step 3: Customer of ID 2 was been updated using PUT" +
                "\n Step 4: Customer of ID 1 was been deleted using DELETE" +
                "\n Step 5: Customers in the REDIS has been display using GET");
    }

    /**
     * This method is for client side GET Request
     * @param urlStr url for GET
     */
    private static void get(String urlStr) {
        try {
            //Url for ApI
            URL url = new URL(urlStr);
            //Create HTTP Client
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            //Set Request medthod to GET
            httpURLConnection.setRequestMethod("GET");
            //Addition header for HTTPS which accepts JSON
            httpURLConnection.setRequestProperty("Accept", "application/json");

            // Check for Code 200 OK from the request
            if (httpURLConnection.getResponseCode() != 200) {
                throw new RuntimeException("HTTP ERROR : "
                        + httpURLConnection.getResponseCode());
            }

            //Capturing JSON body response
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (httpURLConnection.getInputStream())));

            //Output each line from buffer
            String output;
            System.out.print("GET: ");
            while ((output = br.readLine()) != null) {
                System.out.println(output + "\n");
            }

            //Dissconect from http
            httpURLConnection.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

    /**
     * This method is for client side POST Request
     * @param urlStr url for post
     */
    private static void post(String urlStr) {
        try {

            //Url for ApI
            URL url = new URL(urlStr);
            //Create HTTP Client
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            //Set out from raw body as true
            httpURLConnection.setDoOutput(true);
            //Set Request medthod to PUT
            httpURLConnection.setRequestMethod("POST");
            //Addition header for HTTPS which accepts JSON
            httpURLConnection.setRequestProperty("Content-Type", "application/json");

            //POST arguments in JSON form
            String input = "{\"id\":\"2\",\"name\":\"Kane\", \"email\":\"kane@yahoo.com\",\"enrole\":\"2years\"}";

            //Convert string to bytes
            OutputStream os = httpURLConnection.getOutputStream();
            os.write(input.getBytes());
            os.flush();

            // Check for Code 200 OK from the request
            if (httpURLConnection.getResponseCode() != 200) {
                throw new RuntimeException("HTTP ERROR : "
                        + httpURLConnection.getResponseCode());
            }

            //Capturing JSON body response
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (httpURLConnection.getInputStream())));

            //Output each line from buffer
            String output;
            System.out.print("POST: ");
            while ((output = br.readLine()) != null) {
                System.out.println(output + "\n");
            }
            // close https connection
            httpURLConnection.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    /**
     * This method is for client side PUT Request
     * @param urlStr url for PUT
     */
    private static void put(String urlStr) {
        try {

            //Url for ApI
            URL url = new URL(urlStr);
            //Create HTTP Client
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            //Set out from raw body as true
            httpURLConnection.setDoOutput(true);
            //Set Request medthod to PUT
            httpURLConnection.setRequestMethod("PUT");
            //Addition header for HTTPS which accepts JSON
            httpURLConnection.setRequestProperty("Content-Type", "application/json");

            //PUT arguments in JSON form
            String input = "{\"id\":2,\"name\":\"kanye\"}";

            //Convert string to bytes
            OutputStream os = httpURLConnection.getOutputStream();
            os.write(input.getBytes());
            os.flush();

            // Check for Code 200 OK from the request
            if (httpURLConnection.getResponseCode() != 200) {
                throw new RuntimeException("HTTP ERROR : "
                        + httpURLConnection.getResponseCode());
            }

            //Capturing JSON body response
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (httpURLConnection.getInputStream())));

            //Output each line from buffer
            String output;
            System.out.print("PUT: ");
            while ((output = br.readLine()) != null) {
                System.out.println(output + "\n");
            }

            //Dissconect from http
            httpURLConnection.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }


    }

    /**
     * This method is for client side DELETE Request
     * @param urlStr url for Delete
     */
    private static void delete(String urlStr) {
        try {

            //Url for ApI
            URL url = new URL(urlStr);
            //Create HTTP Client
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            //Set Request medthod to DELETE
            httpURLConnection.setRequestMethod("DELETE");
            //Addition header for HTTPS which accepts JSON
            httpURLConnection.setRequestProperty("Accept", "application/json");

            // Check for Code 200 OK from the request
            if (httpURLConnection.getResponseCode() != 200) {
                throw new RuntimeException("HTTP ERROR : "
                        + httpURLConnection.getResponseCode());
            }

            //Capturing JSON body response
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (httpURLConnection.getInputStream())));

            //Output each line from buffer
            String output;
            System.out.print("DELETE: ");
            while ((output = br.readLine()) != null) {
                System.out.println(output + "\n");
            }

            //Dissconect from http
            httpURLConnection.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }
}
