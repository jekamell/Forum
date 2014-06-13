package com.jekamell.crud.blog;

import com.jekamell.crud.blog.controller.HomeController;
import com.jekamell.crud.blog.model.Post;
import com.jekamell.crud.blog.service.BlogService;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;
import static com.jekamell.crud.blog.controller.HomeController.POSTS_PER_PAGE;

public class HomeControllerTest {
    @Test
    public void shouldDisplayRecentPosts() {
        List<Post> expectedPosts = asList(new Post(), new Post(), new Post());

        BlogService blogService = mock(BlogService.class);

        when(blogService.getRecentPosts(POSTS_PER_PAGE)).
                thenReturn(expectedPosts);

        HashMap<String, Object> model = new HashMap<String, Object>();

        HomeController controller = new HomeController(blogService);

        String viewName = controller.showHomePage(model);
        assertEquals("home", viewName);
        assertSame(expectedPosts, model.get("posts"));
        verify(blogService).getRecentPosts(POSTS_PER_PAGE);
    }
}
