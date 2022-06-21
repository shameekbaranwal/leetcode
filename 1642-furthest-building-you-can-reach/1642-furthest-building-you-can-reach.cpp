class Solution {
public:
    int furthestBuilding(vector<int>& heights, int bricks, int ladders) {
        priority_queue<int> pq; //Max Heap 
        int cB = 0,lad=ladders,n = heights.size();
        for(int i=1;i<n;i++)
        {
            if(heights[i]>heights[i-1])
            {
                int diff = heights[i]-heights[i-1];
                cB += diff; //Current No. Of Bricks Required
                pq.push(diff);
                if(cB>bricks) //If required no. of bricks exceeds the 
				{				//available bricks
                    if(lad>0)
                    {
						//Since we have ladder left, we can either directly
						//use it here or we can imagine that we can travel back
						//to the part where we have used the maximum no. of bricks
						//use the ladder there and take back those bricks such
						//that we can use them here.
                        cB-=pq.top();
                        pq.pop();
                        lad--;
                    }
                    else
                    {
                        return i-1;
                    }
                }
            }
        }
		//We reached the last building
        return n-1;
    }
};