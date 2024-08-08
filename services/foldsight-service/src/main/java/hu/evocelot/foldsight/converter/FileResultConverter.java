package hu.evocelot.foldsight.converter;

import org.springframework.stereotype.Component;

import hu.evocelot.foldsight.dto.fileresult.FileResultType;
import hu.evocelot.foldsight.model.FileResult;

/**
 * Converter class that handles conversion from {@link FileResult} to {@link FileResultType}.
 *
 * @author mark.danisovszky
 * @since 0.1.0
 */
@Component
public class FileResultConverter implements EntityConverter<FileResult, FileResultType> {
    @Override
    public FileResultType convert(FileResult fileResult) {
        FileResultType fileResultType = new FileResultType();
        fileResultType.setFileName(fileResult.getFileName());
        fileResultType.setCount(fileResult.getCount());
        return fileResultType;
    }
}
