import {forwardRef} from "react";
import Box from "@mui/material/Box";
import {Avatar, Typography} from "@mui/material";

const Post = forwardRef((props, ref) => {
    const { avatarUrl, username, created, content } = props.post;
    return (
        <Box
            ref={ref}
            sx={{
                display: "flex",
                flexDirection: "row",
                alignItems: "flex-start",
                justifyContent: "space-between",
            }}
        >
            <Box
                sx={{
                    display: "flex",
                    flexDirection: "row",
                    alignItems: "start",
                    marginBottom: 2,
                }}
            >
                <Avatar src={avatarUrl} sx={{ marginRight: 2 }} />
                <Box>
                    <Box sx={{ display: "flex", flexDirection: "column" }}>
                        <Typography
                            sx={{
                                fontSize: 14,
                                fontWeight: 600,
                            }}
                        >
                            {username}
                        </Typography>
                        <Typography
                            sx={{
                                fontSize: 14,
                                fontWeight: 400,
                            }}
                        >
                            {created}
                        </Typography>
                    </Box>
                    <Typography
                        sx={{
                            fontSize: 14,
                        }}
                    >
                        {content}
                    </Typography>
                </Box>
            </Box>
        </Box>
    );
});

export default Post