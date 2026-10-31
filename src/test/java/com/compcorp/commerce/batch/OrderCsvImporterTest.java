package com.compcorp.commerce.batch;
import org.junit.jupiter.api.Test;import org.junit.jupiter.api.io.TempDir;import java.nio.file.*;import static org.junit.jupiter.api.Assertions.*;
class OrderCsvImporterTest{
 @TempDir Path dir;
 @Test void importsValidAndRejectsMalformedRows()throws Exception{Path p=dir.resolve("orders.csv");Files.writeString(p,"order_id,customer,date,quantity,amount\nA,Ada,2026-10-01,2,12.50\nB,Grace,bad-date,1,4.00\nC,Lin,2026-10-02,0,3.00\n");var r=OrderCsvImporter.importFile(p);assertEquals(1,r.accepted().size());assertEquals(2,r.rejected().size());assertEquals("25.00",r.total().toPlainString());}
 @Test void rejectsWrongHeader()throws Exception{Path p=dir.resolve("bad.csv");Files.writeString(p,"a,b\n");assertThrows(java.io.IOException.class,()->OrderCsvImporter.importFile(p));}
 @Test void missingFileRaisesIOException(){assertThrows(java.io.IOException.class,()->OrderCsvImporter.importFile(dir.resolve("missing.csv")));}
}
