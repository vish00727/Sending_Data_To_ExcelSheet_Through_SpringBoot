package com.example.poiji.databaseExcel.serviceImpl;
  import com.example.poiji.databaseExcel.dto.SheetDto;
  import com.example.poiji.databaseExcel.entity.Sheet;
  import com.example.poiji.databaseExcel.repo.SheetRepo;
  import com.example.poiji.databaseExcel.service.SheetService;
  import com.poiji.bind.Poiji;
  import com.poiji.exception.PoijiExcelType;
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.stereotype.Service;
  import org.springframework.web.multipart.MultipartFile;
  import java.io.IOException;
  import java.util.List;
     @Service
     public class SheetServiceImpl implements SheetService {

          @Autowired
          private SheetRepo sheetRepo;

            @Override
            public List<SheetDto> uploadExcelFile(MultipartFile file) throws IOException {
            List<SheetDto> sheetDtos = Poiji.fromExcel(file.getInputStream(), PoijiExcelType.XLSX, SheetDto.class);
            sheetDtos.forEach(dto -> {
            Sheet sheet = new Sheet();
            sheet.setName(dto.getName());
            sheet.setAmount(dto.getAmount());
            sheet.setReceivedDate(dto.getReceivedDate());
            sheet.setNumber(dto.getNumber() );
            sheetRepo.save(sheet);
            });
            return sheetDtos;
       }

     }