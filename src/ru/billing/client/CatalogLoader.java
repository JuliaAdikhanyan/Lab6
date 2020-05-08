package ru.billing.client;

import ru.billing.exceptions.CatalogLoadException;
import ru.billing.stocklist.ItemCatalog;
import java.io.IOException;

public interface CatalogLoader {
    void load(ItemCatalog cat) throws CatalogLoadException, IOException;
}
