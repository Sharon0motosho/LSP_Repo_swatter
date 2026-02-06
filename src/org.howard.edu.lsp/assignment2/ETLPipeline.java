package org.howard.edu.lsp.assignment2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

//Sharon Omotosho
public class ETLPipeline {

    public static void main(String[] args) {

        String inputPath = "data/products.csv";
        String outputPath = "data/transformed_products.csv";

        int rowsRead = 0;
        int rowsWritten = 0;
        int rowsSkipped = 0;

        File inputFile = new File(inputPath);

        if (!inputFile.exists()) {
            System.out.println("ERROR: Input file not found at " + inputPath);
            return;
        }

        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))
        ) {

            writer.write("ProductID,Name,Price,Category,PriceRange");
            writer.newLine();

            String line = reader.readLine();
            if (line == null) {
                printSummary(rowsRead, rowsWritten, rowsSkipped, outputPath);
                return;
            }

            while ((line = reader.readLine()) != null) {
                rowsRead++;

                line = line.trim();
                if (line.isEmpty()) {
                    rowsSkipped++;
                    continue;
                }

                String[] fields = line.split(",");
                if (fields.length != 4) {
                    rowsSkipped++;
                    continue;
                }

                String idStr = fields[0].trim();
                String name = fields[1].trim();
                String priceStr = fields[2].trim();
                String category = fields[3].trim();

                int productId;
                BigDecimal price;

                try {
                    productId = Integer.parseInt(idStr);
                    price = new BigDecimal(priceStr);
                } catch (NumberFormatException e) {
                    rowsSkipped++;
                    continue;
                }


                name = name.toUpperCase();

                boolean wasElectronics = category.equals("Electronics");

                if (wasElectronics) {
                    price = price.multiply(new BigDecimal("0.90"));
                }

                price = price.setScale(2, RoundingMode.HALF_UP);

                if (wasElectronics && price.compareTo(new BigDecimal("500.00")) > 0) {
                    category = "Premium Electronics";
                }

                String priceRange;
                if (price.compareTo(new BigDecimal("10.00")) <= 0) {
                    priceRange = "Low";
                } else if (price.compareTo(new BigDecimal("100.00")) <= 0) {
                    priceRange = "Medium";
                } else if (price.compareTo(new BigDecimal("500.00")) <= 0) {
                    priceRange = "High";
                } else {
                    priceRange = "Premium";
                }

                writer.write(
                    productId + "," +
                    name + "," +
                    price.toString() + "," +
                    category + "," +
                    priceRange
                );
                writer.newLine();

                rowsWritten++;
            }

        } catch (IOException e) {
            System.out.println("ERROR: An I/O error occurred while processing files.");
            return;
        }

        printSummary(rowsRead, rowsWritten, rowsSkipped, outputPath);
    }

    private static void printSummary(int read, int written, int skipped, String outputPath) {
        System.out.println("Run Summary:");
        System.out.println("Rows read: " + read);
        System.out.println("Rows transformed: " + written);
        System.out.println("Rows skipped: " + skipped);
        System.out.println("Output file: " + outputPath);
    }
}
