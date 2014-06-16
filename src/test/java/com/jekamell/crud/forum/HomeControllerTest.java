package com.jekamell.crud.forum;

import com.jekamell.crud.forum.controller.HomeController;
import com.jekamell.crud.forum.model.Post;
import com.jekamell.crud.forum.service.ForumService;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;
import static com.jekamell.crud.forum.controller.HomeController.POSTS_PER_PAGE;

public class HomeControllerTest {
    @Test
    public void shouldDisplayRecentPosts() {
        List<Post> expectedPosts = asList(new Post(), new Post(), new Post());

        ForumService forumService = mock(ForumService.class);

        when(forumService.getRecentPosts(POSTS_PER_PAGE)).
                thenReturn(expectedPosts);

        HashMap<String, Object> model = new HashMap<String, Object>();

        HomeController controller = new HomeController(forumService);

        String viewName = controller.showHomePage(model);
        assertEquals("home", viewName);
        assertSame(expectedPosts, model.get("posts"));
        verify(forumService).getRecentPosts(POSTS_PER_PAGE);
    }
}
