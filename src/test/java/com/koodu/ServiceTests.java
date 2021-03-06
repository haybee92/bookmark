package com.koodu;

import com.koodu.exception.BookmarkException;
import com.koodu.models.Bookmark;
import com.koodu.models.Response;
import com.koodu.services.BookmarkService;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Abiola.Adebanjo
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class ServiceTests {

    @Autowired
    BookmarkService bookmarkService;

    @Before
    public void setUp() throws BookmarkException {
        bookmarkService.deleteAllBookmarks();
        assertEquals("Respository not cleared", 0, bookmarkService.countBookmarks());
    }

    @Test
    public void testCreateBookmark() throws BookmarkException {
        Bookmark bookmark = new Bookmark("af_banjo", "https://google.com", "14-11-2016 09:17", "15-11-2016 09:17");
        Response response = bookmarkService.createBookmark(bookmark);

        assertEquals("message mixmatch", "Success", response.getMessage());
    }

}
