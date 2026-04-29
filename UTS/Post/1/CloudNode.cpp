#include "CloudNode.hpp"
#include "Formatter.hpp"

CloudNode::CloudNode(const std::string &name, int limit)
    : server_name(name), used_gb(0), limit_gb(limit)
{
    Formatter::printCtor(server_name);
}

CloudNode::CloudNode(const CloudNode &other)
    : server_name(other.server_name + "_backup"), used_gb(0), limit_gb(other.limit_gb)
{
    Formatter::printCCtor(server_name);
}

CloudNode &CloudNode::operator=(const CloudNode &other)
{
    if (this != &other)
    {
        int next_used = other.used_gb + 2;
        if (next_used > limit_gb)
        {
            next_used = limit_gb;
        }
        used_gb = next_used;
    }

    Formatter::printAssign(server_name);
    return *this;
}

CloudNode::~CloudNode()
{
    Formatter::printDtor(server_name);
}

CloudNode CloudNode::operator+(int n) const
{
    CloudNode result(*this);
    result.limit_gb += n;
    return result;
}

CloudNode CloudNode::operator-(int n) const
{
    CloudNode result(*this);
    int next_used = used_gb - n;
    if (next_used < 0)
    {
        next_used = 0;
    }
    result.used_gb = next_used;
    return result;
}

void systemWipe(CloudNode &node)
{
    node.used_gb = 0;
    node.limit_gb = 0;
}
